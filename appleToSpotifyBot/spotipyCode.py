import os
import sys
import json
from json.decoder import JSONDecodeError
import spotipy
import spotipy.util as util
import requests
import re
from itunesLibrary import library
#6si8blnqlfxm2ddj5ysr6mu8v
clientID = "80b8f78731794ffcbd85198c5d794938"
secretID = "d9c3c2b0fe514a888187744f7dbdb797"
redirect = "http://localhost:8888"
userID = sys.argv[1]
oAuthToken = util.prompt_for_user_token(userID, scope = "playlist-modify-public",client_id=clientID, client_secret=secretID,redirect_uri=redirect)
#print("oAuth Token is:    "+oAuthToken)
if (oAuthToken):
    sp=spotipy.Spotify(auth=oAuthToken)
else:
    print("bad authentication")

def makePlayList(nameOfPlaylist):
    url = "https://api.spotify.com/v1/users/{}/playlists".format(userID)
    body = json.dumps({ "name":nameOfPlaylist, "public":True, "collaborative":False, "description":"playlist made using python by ken"} )
    tempVar = "Bearer {}".format(oAuthToken)
    header = { "Content-Type":"application/json","Authorization":tempVar}
    toString = requests.post(url,data=body, headers=header)
    theString = toString.json()
    return theString["id"]
def searchSong(n):
    song = n
    result = sp.search(song,limit = 1,offset=0,type='track')
    toString = json.dumps(result,sort_keys=True,indent=3)
    f = re.findall('external_urls(.+?)}',toString)
    s=result['tracks']['items'][0]["external_urls"]['spotify']
    #print(s)
    return s
    
def addSongToPlayList(playlistID,theSong):
    temp = theSong
    song=searchSong(temp)
    songList = []
    songList.append(song)
    sp.user_playlist_add_tracks(user=userID,playlist_id=playlistID,tracks=songList,position=None)
#searchSong("J. Cole 2014 Forest Hills Drive Wet Dreamz")

#location = input("what is the location of the xml file?")
            #for future users, this could be inputted so that this doesn't only work on my laptop

#some Apple Music Songs don't exist or we pulled a local file from the computer and will return failed songs
location = '/Users/kenichimatsuo/Desktop/XMLFiles/Library.xml'
lib = library.parse(location)
for i in lib.playlists:
    length = len(str(i))
    playlistTitle = str(i)[2:length]
    index = 0
    for j in range(len(playlistTitle)):
        if (playlistTitle[j]=="'"):
            index = j
    actualPlaylistTitle = playlistTitle[0:index]
    if(actualPlaylistTitle!="Library" and actualPlaylistTitle != "Downloaded" and actualPlaylistTitle != "Music"):
        identification=makePlayList(actualPlaylistTitle)
        #print("identification is "+identification+" playlist name is "+actualPlaylistTitle)
        for z in i.items:
            ken = str(z)
            try:
                #print("song added is "+ken)
                addSongToPlayList(identification,ken)
            except:
                print(ken+" was not added to "+actualPlaylistTitle+" playlist")








