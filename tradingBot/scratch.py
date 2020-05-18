'''
Part 1 - oAuth Bullshit
'''
import urllib.request
import webbrowser
import time
import requests
from urllib.parse import unquote
from splinter import Browser
from apiKey import apiKey #the key with the @Amer.oauthap stuff in the end of the string
from apiKey import nakedKey #this is the consumer API key 
from apiKey import user_id #your TD not developer Account user
from apiKey import password #your TD not developer Acc PW
from datetime import date
def authenticator():
    localHostURLEncoded = 'http%3A%2F%2Flocalhost' 
    TDBaseURL = 'https://auth.tdameritrade.com/auth?response_type=code&redirect_uri='+localHostURLEncoded+'&client_id='+nakedKey+'%40AMER.OAUTHAP'
    executable_path = {'executable_path':r'/Users/kenichimatsuo/DataSets/TradingBot/chromedriver'}
    browser = Browser('chrome', **executable_path, headless=False)
    browser.visit(TDBaseURL)
    browser.find_by_id('username').first.fill(user_id)
    browser.find_by_id('password').first.fill(password)
    browser.find_by_id('accept').first.click() 
    bigURL= browser.url
    #right here, answer the security question on chrome browser
    while (('https://localhost/?code=' in str(bigURL))==False):
        bigURL= browser.url
    bigURL= browser.url
    silverToken = str(bigURL).split("code=")
    goldToken = silverToken[1]
    browser.quit 
    decodedToken = unquote(goldToken)
    finalURL = r'https://api.tdameritrade.com/v1/oauth2/token'
    headers = {'Conent-Type':'application/x-www-form-urlencoded'}
    urlDump = {'grant_type':'authorization_code','access_type':'offline', 'code':decodedToken, 'client_id':apiKey, 'redirect_uri':'http://localhost'}
    gotValue = requests.post(finalURL, headers = headers, data=urlDump)
    print(gotValue.json())
    logDest = '/Users/kenichimatsuo/DataSets/TradingBot/logs/'+str(date.today())
    importDest = '/Users/kenichimatsuo/DataSets/TradingBot/logs/Key.py'
    f = open(logDest,"w+")
    f.write("Date-"+str(date.today())+"  GOLDTOKEN-"+goldToken)
    f.close()
    r = open(importDest,"w+")
    r.write("GOLDENTOKEN = "+goldToken)
    r.close()
#by the way, GOLDENTICKET is the ENCODED API token, URLLIB.unquote() everytime to decode that!!!
#by the way, GOLDENTICKET is the ENCODED API token, URLLIB.unquote() everytime to decode that!!!
#by the way, GOLDENTICKET is the ENCODED API token, URLLIB.unquote() everytime to decode that!!!
#by the way, GOLDENTICKET is the ENCODED API token, URLLIB.unquote() everytime to decode that!!!














