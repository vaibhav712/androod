# eLyrics
eLryrics,Android application, to study english via popular song and TED video with lyrics
<a href="http://photran.me/wp-content/uploads/2015/02/ic_launcher-web.png"><img class="size-medium wp-image-209 aligncenter" src="http://photran.me/wp-content/uploads/2015/02/ic_launcher-web-300x300.png" alt="ic_launcher-web" width="300" height="300" /></a>



I create eLryrics Android to study Material Design. But I can't public app on Google Play because promotional screenshots must not contain images that appear confusingly similar to existing products.
I will public eLryrics on GitHub

<strong>Description</strong>

eLryrics  to study english via popular song and TED video with lyrics

<a href="http://photran.me/wp-content/uploads/2015/02/80088e52-00f2-4e64-82f9-727e87f9abe2.png"><img class="aligncenter wp-image-241 size-large" src="http://photran.me/wp-content/uploads/2015/02/80088e52-00f2-4e64-82f9-727e87f9abe2-613x1024.png" alt="" width="613" height="1024" /></a>

<a href="http://photran.me/wp-content/uploads/2015/02/1ccbc5aa-12ac-424b-a145-219d4020303d.png"><img class="aligncenter wp-image-212 size-large" src="http://photran.me/wp-content/uploads/2015/02/1ccbc5aa-12ac-424b-a145-219d4020303d-613x1024.png" alt="" width="613" height="1024" /></a>

<a href="http://photran.me/wp-content/uploads/2015/02/e9a0cfeb-02ba-46b9-8b49-f682fc7048c3.png"><img class="aligncenter wp-image-240 size-large" src="http://photran.me/wp-content/uploads/2015/02/e9a0cfeb-02ba-46b9-8b49-f682fc7048c3-613x1024.png" alt="" width="613" height="1024" /></a><a href="http://photran.me/wp-content/uploads/2015/02/4f4f0ea7-c71a-4014-9dca-dd371db099f7.png">
</a> <a href="http://photran.me/wp-content/uploads/2015/02/0176b0d1-b063-4353-9922-45707e9ca43a.png">
</a><a href="http://photran.me/wp-content/uploads/2015/02/0176b0d1-b063-4353-9922-45707e9ca43a.png"><img class="aligncenter wp-image-203 size-large" src="http://photran.me/wp-content/uploads/2015/02/0d4cbd9e-e4f5-4b3d-b962-7431c0e06800-613x1024.png" alt="0d4cbd9e-e4f5-4b3d-b962-7431c0e06800" width="613" height="1024" /></a><a href="http://photran.me/wp-content/uploads/2015/02/0176b0d1-b063-4353-9922-45707e9ca43a.png"><img class="aligncenter wp-image-206 size-large" src="http://photran.me/wp-content/uploads/2015/02/218bea3d-dcb3-481e-89ad-c4263bc2bce8-613x1024.png" alt="218bea3d-dcb3-481e-89ad-c4263bc2bce8" width="613" height="1024" /></a><a href="http://photran.me/wp-content/uploads/2015/02/0176b0d1-b063-4353-9922-45707e9ca43a.png"><img class="aligncenter wp-image-205 size-large" src="http://photran.me/wp-content/uploads/2015/02/0176b0d1-b063-4353-9922-45707e9ca43a-1024x613.png" alt="0176b0d1-b063-4353-9922-45707e9ca43a" width="634" height="379" /></a>

<strong><a title="APK File" href="https://drive.google.com/file/d/0B3i8zKFHmqE6TF9reGdocGpQQ28/view?usp=sharing" target="_blank">APK File

</strong>

1. Connect to Parse service
<pre>    private void settingParser() {
        String appID = "E8FDGxCEMeJwm58KFK7Vp6luSGoVYzou5ceQMnTN";
        String clientID = "mnUji5Pak7cWFAOeoK5boGOpVhiWolY6C5lTCPf0";
        Parse.initialize(this, appID, clientID);
    }
</pre>
2.Load more on Parse service<strong>
</strong>using limit and skip
<pre>    private ListlistSongMp3s = new ArrayList();
    private int pageSize = 10;
    private int skip = 0;
    private FindCallback completion = new FindCallback() {

        @Override
        public void done(List arg0, ParseException arg1) {

            googleProgress.setVisibility(View.GONE);
            if (arg1 != null) {
                Log.v("ParseException", "" + arg1.toString());
            } else {
                for (ParseObject object : arg0) {
                    SongInforMp3 songInforMp3 = PMHelper
                            .getSongInforMp3FormParseObject(object);
                    listSongMp3s.add(0,songInforMp3);
                }
                skip = skip + pageSize;
                Log.v("completion","" + skip + "-" + listSongMp3s.size());
                initAdapter();
            }
            swipeRefreshLayout.setRefreshing(false);
        }
    };
    
    private void callParser(String dataBaseName) {
        ParseQuery query = ParseQuery.getQuery(dataBaseName);
        query.setLimit(pageSize);
        query.setSkip(skip);
        query.findInBackground(completion);
    }
</pre>

Service : Parse

<a href="http://photran.me/wp-content/uploads/2015/02/ParseLogo650.jpg"><img class="size-medium wp-image-208 aligncenter" src="http://photran.me/wp-content/uploads/2015/02/ParseLogo650-300x125.jpg" alt="ParseLogo650" width="300" height="125" /></a>

Component open source:

-<a href="http://square.github.io/picasso/" target="_blank">Picasso</a>

-<a href="https://github.com/navasmdc/MaterialDesignLibrary" target="_blank">Material Design</a>

 <a title="PTPageView" href="https://github.com/ttpho/PTPageView" target="_blank">-PTPageView</a>


<strong>J</strong><strong>son Files form Parse</strong>
- <a href="https://drive.google.com/file/d/0B3i8zKFHmqE6T0laX3EzZ2FMWlU/view?usp=sharing" target="_blank">Songs
</a>preview
<pre>{ "results": [
{
"artist": "Celine Dion",
"createdAt": "2015-01-21T13:48:21.892Z",
"lyrics_file": "http://static.mp3.zdn.vn/lyrics/2014/5/2/527281e8ddfc049dea53fd9e1f218af9_1073790421.lrc",
"objectId": "8l9NunLO7M",
"song_id_encode": "ZWZA0EZZ",
"source128": "http://api.mp3.zing.vn/api/mobile/source/song/LGJGTLGNVNEGADLTLDJTDGLG",
"thumbnail": "covers/d/a/daf3eeae9d3aeb5bdf9a2b9f86ba8bab_1289629808.jpg",
"title": "My Heart Will Go On",
"updatedAt": "2015-01-21T13:48:21.892Z"
},
{
"artist": "Westlife",
"createdAt": "2015-01-21T13:43:19.484Z",
"lyrics_file": "http://static.mp3.zdn.vn/lyrics/2014/d/a/da775ec7e1ad88d3459f5e0128fe8d1f_1073769166.lrc",
"objectId": "bG8WpWuMLv",
"song_id_encode": "ZWZ9BBUE",
"source128": "http://api.mp3.zing.vn/api/mobile/source/song/LGJGTLGNVNXELXXTLDJTDGLG",
"thumbnail": "covers/7/3/73688444a73a76169d03b689a7e785cf_1288583299.jpg",
"title": "I Lay My Love On You",
"updatedAt": "2015-01-21T13:43:19.484Z"
}
] }
</pre>
- <a href="https://drive.google.com/file/d/0B3i8zKFHmqE6bE43cVF4dG5VQ1E/view?usp=sharing" target="_blank">Videos
</a>

preview
<pre>{ "results": [
{
"createdAt": "2014-12-08T12:29:33.579Z",
"links": "https://www.youtube.com/watch?v=PSRL3m29Pgk",
"objectId": "tF87ZHPTAx",
"titles": "Josh Kaufman: Học mọi thứ chỉ với 20 giờ",
"updatedAt": "2014-12-17T03:56:34.741Z"
},
{
"createdAt": "2014-12-10T13:47:09.960Z",
"links": "https://www.youtube.com/watch?v=zwnn0kRMDfk",
"objectId": "vSHKPSeG51",
"titles": "Derek Sivers: Tại sao nói trước bước không qua?",
"updatedAt": "2014-12-17T03:55:22.877Z"
}
]}
</pre>
&nbsp;


<pre>
<form action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_top"><input name="cmd" type="hidden" value="_s-xclick" />
<input name="hosted_button_id" type="hidden" value="TLMPJVLBR2WAE" />
<input alt="PayPal - The safer, easier way to pay online!" name="submit" src="https://www.paypalobjects.com/en_US/i/btn/btn_donateCC_LG.gif" type="image" />
<img src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" alt="" width="1" height="1" border="0" /></form>
<pre>
