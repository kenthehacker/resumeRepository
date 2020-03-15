import requests
import time
import pandas as pd 
import matplotlib 
import matplotlib.pyplot as plt 
from selenium import webdriver
from splinter import Browser
import urllib
#the following imports the userid pw for the td bank account and the API key
from copyandpaste import user_id
from copyandpaste import password
from copyandpaste import key
testSymbol='AAPL'
user_id=user_id
password = password
key = key

#automated Authentication Bot:
def authenticator():
    #the following couple lines basically automates the act of opening up a browser, logging into your bank account, and getting the access token for your API

    executable_path = {'executable_path':r'/Users/kenichimatsuo/Documents/PythonShit/TDAmeritradeBot1/chromedriver'}
    browser = Browser('chrome', **executable_path, headless=False)
   
    #for other users, download a chromedriver that fits your chrome browser version and store it into a directory and change
    #the above executable path directory into that directory
    method = 'GET'
    auth_url = 'https://auth.tdameritrade.com/auth?'
    client_code = key+'@AMER.OAUTHAP'
    auth_params = {'response_type':'code','redirect_uri':'http://localhost','client_id':client_code}
    built_auth_url = requests.Request(method, auth_url, params= auth_params).prepare()
    built_auth_url=built_auth_url.url
    browser.visit(built_auth_url)
    import time
    #the following four lines basically finds the buttons on the webpage and clicks on it for you
    log_in_params = {'username':user_id,'password':password}
    browser.find_by_id('username').first.fill(log_in_params['username'])
    browser.find_by_id('password').first.fill(log_in_params['password'])
    browser.find_by_id('accept').first.click() 
    time.sleep(1)
    browser.find_by_id('accept').first.click() 
    time.sleep(1)
    parseUrl= browser.url
    #parses the URL for the access token
    parsedUrl = urllib.parse.unquote(parseUrl.split('code=')[1])
    browser.quit
    resource_url = r'https://api.tdameritrade.com/v1/oauth2/token'
    headers = {'Conent-Type':'application/x-www-form-urlencoded'}
    API_params = {'grant_type':'authorization_code','access_type':'offline', 'code':parsedUrl, 'client_id':key, 'redirect_uri':'http://localhost'}
    #the Access Token for the API account is actually stored inside the 404 error URL after "code="
    authReply = requests.post(resource_url, headers = headers, data=API_params)
    decoded_stuff = authReply.json()
    return decoded_stuff
#authenticator()

def get_accounts(j):
    #calls on the access token finder definition
    accesstoken = authenticator()
    accesstoken = accesstoken['access_token']
    
    d = 'Bearer '+accesstoken
    headers = {'Authorization':d}
    url = 'https://api.tdameritrade.com/v1/accounts'
    stuff = requests.get(url=url, headers=headers)
    #stores into a variable all of the data regarding those accoutns that i requested for i.e. the amount of money that i have 
    information = stuff.json()
    account_id = information[0]['securitiesAccount']['accountId']
    if j==1:
        return account_id
        #sometimes i only want the account ID so i make the function able to return only the account id 
    elif j==2:
        return information
        #uhm, basically returns a huge blarg at you, kinda useless
    else:
        return "ERROR Invalid Input Into Function"
#get_accounts()
def get_account(**kwargs):
    #same thing as get accounts but it returns a blarg of information for one single account, kinda useless
    accesstoken = authenticator()
    accesstoken = accesstoken['access_token']
    d = 'Bearer '+accesstoken
    headers = {'Authorization':d}
    account_id=get_accounts(1)   
    url = 'https://api.tdameritrade.com/v1/accounts/'+str(account_id)
    stuff = requests.get(url=url, headers=headers)
    s = stuff.json()
    print(s)

#get_account()


'''
tech analysis goes here:
'''


#ken's Version of price history getter:
def price_history_getter(**kwargs):
    url = 'https://api.tdameritrade.com/v1/marketdata/{}/pricehistory'.format(kwargs.get('symbol'))
    params = {}
    #the price history endpoint on TD requirs info like what period i want, what is the stock symbol, and etc, so all of that requested
    #information is stored inside of the params dictionary variable 
    params['apikey']=key
    for i in kwargs:
        params[i]=kwargs.get(i)
        #loops through all of the information i gave to the function and adds it into the params
    f = requests.get(url,params)
    return f.json()




def get_quotes(**kwargs):
    #for architecture of the function, look at the pricehistorygetter
    url='https://api.tdameritrade.com/v1/marketdata/quotes'
    params ={}
    params['apikey']=key
    list_of_stocks = []
    for j in kwargs.get('symbol'):
        list_of_stocks.append(j)
    
    params['symbol']=list_of_stocks
    '''
    for i in kwargs:
        params[i]=kwargs.get(i)
    requester=requests.get(url,params)
    '''
    requester=requests.get(url,params)
    return requester.json()
#print(get_quotes(symbol=['AAPL,TSLA']))

#converts human dates into epoch times
def epochCalculator(date):
    #date_time = '29.08.2011 11:05:02'
    date_time = date
    pattern = '%d.%m.%Y %H:%M:%S'
    epoch = int(time.mktime(time.strptime(date_time, pattern)))*1000
    return epoch
#epochCalculator('29.08.2011 13:05:02')

#this can only accomodate for a yearly chart with daily frequency
def simple_moving_average(day,stksymbol,period,periodType,frequencyType,frequency):
    priceHistory=price_history_getter(symbol=stksymbol, period=period, periodType=periodType, frequencyType = frequencyType, frequency=frequency)
    #priceHistory=price_history_getter(symbol=stksymbol, period=2, periodType="year", frequencyType = 'daily', frequency=1)
    print(priceHistory)
    table = {}
    endpoint = day
    #the endpoint needs to be modified since SMA graph will be cut short, we need to extend at how much data is being pulled 

    iteration = 0
    outerCounter = len(priceHistory['candles'])
    while outerCounter>endpoint:
        counter = day
        index = len(priceHistory['candles'])-iteration
        summation = 0
        while counter>=0:
            summation=summation+priceHistory['candles'][index-(day-counter)]['close']
            counter = counter-1
        average=summation/day
        #['candles'][0]['close']
        outerCounter = outerCounter-1
        iteration = iteration+1
        #remember that all of the data inside the dict are backwards
        table[index]=average

simple_moving_average(20,'AAPL',2,'year','daily',1)



def exponential_moving_average(**kwargs):
    pass

################ rubbish pile on the bottom






'''
a=epochCalculator('09.01.2020 8:05:02')
b=epochCalculator('09.01.2020 10:05:02')
print(a)
print(b)
'''

'''
s = price_history_getter(symbol=testSymbol, period=2, periodType="year", frequencyType = 'daily', frequency=1)
p = shist['candles'][0]['close']
print(p)
'''

'''
s=s.split()
counter = 0
for i in s:
    if 'high' in i:
        counter = counter+1
print(counter)
'''
'''
Example: For a 2 day / 1 min chart, the values would be:

period: 2
periodType: day
frequency: 1
frequencyType: min

'''

#print(price_history_getter(symbol=testSymbol,startDate=a,endDate=b, frequencyType = 'minute'))
'''
fundamental analysis shit goes here
'''


