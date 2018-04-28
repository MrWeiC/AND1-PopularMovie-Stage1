package io.weichen.popularmovie;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.ArrayList;

import static io.weichen.popularmovie.BuildConfig.THEMOVIEDB_API_KEY;
import static io.weichen.popularmovie.utilities.NetworkUtils.CATEGORY_POPULAR;
import static io.weichen.popularmovie.utilities.NetworkUtils.buildUrl;
import static io.weichen.popularmovie.utilities.TheMovieDBJSONUtils.getMovieDataFromJSON;
import static junit.framework.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
public class UtilitiesUnitTest {


    @Test
    public void CheckUtilitiesBuildUrl_popular(){
        String targetString = "http://api.themoviedb.org/3/movie/popular?page=1&api_key="+THEMOVIEDB_API_KEY;
        String buildURL = buildUrl(CATEGORY_POPULAR).toString();
        assertEquals(targetString,buildURL);
    }

    @Test
    public void getMovieData_size() throws JSONException {
        ArrayList<MovieData> testMovieArrayList = getMovieDataFromJSON(jsonStr);
        assertEquals(testMovieArrayList.size(),20);
    }

    String jsonStr = "{\n" +
            "    \"page\": 1,\n" +
            "    \"total_results\": 19916,\n" +
            "    \"total_pages\": 996,\n" +
            "    \"results\": [\n" +
            "        {\n" +
            "            \"vote_count\": 1522,\n" +
            "            \"id\": 337167,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 6,\n" +
            "            \"title\": \"Fifty Shades Freed\",\n" +
            "            \"popularity\": 732.998105,\n" +
            "            \"poster_path\": \"/jjPJ4s3DWZZvI4vw8Xfi4Vqa1Q8.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Fifty Shades Freed\",\n" +
            "            \"genre_ids\": [\n" +
            "                18,\n" +
            "                10749\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/9ywA15OAiwjSTvg3cBs9B7kOCBF.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"Believing they have left behind shadowy figures from their past, newlyweds Christian and Ana fully embrace an inextricable connection and shared life of luxury. But just as she steps into her role as Mrs. Grey and he relaxes into an unfamiliar stability, new threats could jeopardize their happy ending before it even begins.\",\n" +
            "            \"release_date\": \"2018-02-07\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 7048,\n" +
            "            \"id\": 269149,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7.7,\n" +
            "            \"title\": \"Zootopia\",\n" +
            "            \"popularity\": 392.44777,\n" +
            "            \"poster_path\": \"/sM33SANp9z6rXW8Itn7NnG1GOEs.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Zootopia\",\n" +
            "            \"genre_ids\": [\n" +
            "                16,\n" +
            "                12,\n" +
            "                10751,\n" +
            "                35\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/mhdeE1yShHTaDbJVdWyTlzFvNkr.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"Determined to prove herself, Officer Judy Hopps, the first bunny on Zootopia's police force, jumps at the chance to crack her first case - even if it means partnering with scam-artist fox Nick Wilde to solve the mystery.\",\n" +
            "            \"release_date\": \"2016-02-11\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 887,\n" +
            "            \"id\": 299536,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 8.8,\n" +
            "            \"title\": \"Avengers: Infinity War\",\n" +
            "            \"popularity\": 310.885723,\n" +
            "            \"poster_path\": \"/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Avengers: Infinity War\",\n" +
            "            \"genre_ids\": [\n" +
            "                12,\n" +
            "                878,\n" +
            "                14,\n" +
            "                28\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/bOGkgRGdhrBYJSLpXaxhXVstddV.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.\",\n" +
            "            \"release_date\": \"2018-04-25\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 316,\n" +
            "            \"id\": 427641,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 5.9,\n" +
            "            \"title\": \"Rampage\",\n" +
            "            \"popularity\": 238.567308,\n" +
            "            \"poster_path\": \"/30oXQKwibh0uANGMs0Sytw3uN22.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Rampage\",\n" +
            "            \"genre_ids\": [\n" +
            "                28,\n" +
            "                12,\n" +
            "                878\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/wrqUiMXttHE4UBFMhLHlN601MZh.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"Primatologist Davis Okoye shares an unshakable bond with George, the extraordinarily intelligent, silverback gorilla who has been in his care since birth.  But a rogue genetic experiment gone awry mutates this gentle ape into a raging creature of enormous size.  To make matters worse, it’s soon discovered there are other similarly altered animals.  As these newly created alpha predators tear across North America, destroying everything in their path, Okoye teams with a discredited genetic engineer to secure an antidote, fighting his way through an ever-changing battlefield, not only to halt a global catastrophe but to save the fearsome creature that was once his friend.\",\n" +
            "            \"release_date\": \"2018-04-12\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 4076,\n" +
            "            \"id\": 354912,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7.8,\n" +
            "            \"title\": \"Coco\",\n" +
            "            \"popularity\": 236.445035,\n" +
            "            \"poster_path\": \"/eKi8dIrr8voobbaGzDpe8w0PVbC.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Coco\",\n" +
            "            \"genre_ids\": [\n" +
            "                12,\n" +
            "                35,\n" +
            "                10751,\n" +
            "                16\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/askg3SMvhqEl4OL52YuvdtY40Yb.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"Despite his family’s baffling generations-old ban on music, Miguel dreams of becoming an accomplished musician like his idol, Ernesto de la Cruz. Desperate to prove his talent, Miguel finds himself in the stunning and colorful Land of the Dead following a mysterious chain of events. Along the way, he meets charming trickster Hector, and together, they set off on an extraordinary journey to unlock the real story behind Miguel's family history.\",\n" +
            "            \"release_date\": \"2017-10-27\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 4378,\n" +
            "            \"id\": 284054,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7.3,\n" +
            "            \"title\": \"Black Panther\",\n" +
            "            \"popularity\": 203.644026,\n" +
            "            \"poster_path\": \"/uxzzxijgPIY7slzFvMotPv8wjKA.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Black Panther\",\n" +
            "            \"genre_ids\": [\n" +
            "                28,\n" +
            "                12,\n" +
            "                14,\n" +
            "                878\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/AlFqBwJnokrp9zWTXOUv7uhkaeq.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"King T'Challa returns home from America to the reclusive, technologically advanced African nation of Wakanda to serve as his country's new leader. However, T'Challa soon finds that he is challenged for the throne by factions within his own country as well as without.  Using powers reserved to Wakandan kings, T'Challa assumes the Black Panther mantel to join with girlfriend Nakia, the queen-mother, his princess-kid sister,  members of the Dora Milaje (the Wakandan \\\"special forces\\\"), and an American secret agent, to prevent Wakanda from being dragged into a world war.\",\n" +
            "            \"release_date\": \"2018-02-13\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 8062,\n" +
            "            \"id\": 321612,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 6.8,\n" +
            "            \"title\": \"Beauty and the Beast\",\n" +
            "            \"popularity\": 192.257661,\n" +
            "            \"poster_path\": \"/tWqifoYuwLETmmasnGHO7xBjEtt.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Beauty and the Beast\",\n" +
            "            \"genre_ids\": [\n" +
            "                10751,\n" +
            "                14,\n" +
            "                10749\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/6aUWe0GSl69wMTSWWexsorMIvwU.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"A live-action adaptation of Disney's version of the classic tale of a cursed prince and a beautiful young woman who helps him break the spell.\",\n" +
            "            \"release_date\": \"2017-03-16\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 5150,\n" +
            "            \"id\": 181808,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7.1,\n" +
            "            \"title\": \"Star Wars: The Last Jedi\",\n" +
            "            \"popularity\": 187.999611,\n" +
            "            \"poster_path\": \"/kOVEVeg59E0wsnXmF9nrh6OmWII.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Star Wars: The Last Jedi\",\n" +
            "            \"genre_ids\": [\n" +
            "                14,\n" +
            "                12,\n" +
            "                878\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/oVdLj5JVqNWGY0LEhBfHUuMrvWJ.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"Rey develops her newly discovered abilities with the guidance of Luke Skywalker, who is unsettled by the strength of her powers. Meanwhile, the Resistance prepares to do battle with the First Order.\",\n" +
            "            \"release_date\": \"2017-12-13\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 7695,\n" +
            "            \"id\": 198663,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7,\n" +
            "            \"title\": \"The Maze Runner\",\n" +
            "            \"popularity\": 162.893854,\n" +
            "            \"poster_path\": \"/coss7RgL0NH6g4fC2s5atvf3dFO.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"The Maze Runner\",\n" +
            "            \"genre_ids\": [\n" +
            "                28,\n" +
            "                9648,\n" +
            "                878,\n" +
            "                53\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/lkOZcsXcOLZYeJ2YxJd3vSldvU4.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"Set in a post-apocalyptic world, young Thomas is deposited in a community of boys after his memory is erased, soon learning they're all trapped in a maze that will require him to join forces with fellow “runners” for a shot at escape.\",\n" +
            "            \"release_date\": \"2014-09-10\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 12714,\n" +
            "            \"id\": 118340,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7.9,\n" +
            "            \"title\": \"Guardians of the Galaxy\",\n" +
            "            \"popularity\": 156.01878,\n" +
            "            \"poster_path\": \"/y31QB9kn3XSudA15tV7UWQ9XLuW.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Guardians of the Galaxy\",\n" +
            "            \"genre_ids\": [\n" +
            "                28,\n" +
            "                878,\n" +
            "                12\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/bHarw8xrmQeqf3t8HpuMY7zoK4x.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"Light years from Earth, 26 years after being abducted, Peter Quill finds himself the prime target of a manhunt after discovering an orb wanted by Ronan the Accuser.\",\n" +
            "            \"release_date\": \"2014-07-30\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 753,\n" +
            "            \"id\": 447332,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7.5,\n" +
            "            \"title\": \"A Quiet Place\",\n" +
            "            \"popularity\": 154.994833,\n" +
            "            \"poster_path\": \"/nAU74GmpUk7t5iklEp3bufwDq4n.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"A Quiet Place\",\n" +
            "            \"genre_ids\": [\n" +
            "                18,\n" +
            "                27,\n" +
            "                53,\n" +
            "                878\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/tZmr0ozxSc2GasRuddtlRkf7f68.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"A family is forced to live in silence while hiding from creatures that hunt by sound.\",\n" +
            "            \"release_date\": \"2018-04-05\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 5784,\n" +
            "            \"id\": 284053,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7.4,\n" +
            "            \"title\": \"Thor: Ragnarok\",\n" +
            "            \"popularity\": 147.571732,\n" +
            "            \"poster_path\": \"/rzRwTcFvttcN1ZpX2xv4j3tSdJu.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Thor: Ragnarok\",\n" +
            "            \"genre_ids\": [\n" +
            "                28,\n" +
            "                12,\n" +
            "                14\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/kaIfm5ryEOwYg8mLbq8HkPuM1Fo.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"Thor is imprisoned on the other side of the universe and finds himself in a race against time to get back to Asgard to stop Ragnarok, the prophecy of destruction to his homeworld and the end of Asgardian civilization, at the hands of an all-powerful new threat, the ruthless Hela.\",\n" +
            "            \"release_date\": \"2017-10-25\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 14414,\n" +
            "            \"id\": 24428,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7.5,\n" +
            "            \"title\": \"The Avengers\",\n" +
            "            \"popularity\": 140.074029,\n" +
            "            \"poster_path\": \"/cezWGskPY5x7GaglTTRN4Fugfb8.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"The Avengers\",\n" +
            "            \"genre_ids\": [\n" +
            "                878,\n" +
            "                28,\n" +
            "                12\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/hbn46fQaRmlpBuUrEiFqv0GDL6Y.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"When an unexpected enemy emerges and threatens global safety and security, Nick Fury, director of the international peacekeeping agency known as S.H.I.E.L.D., finds himself in need of a team to pull the world back from the brink of disaster. Spanning the globe, a daring recruitment effort begins!\",\n" +
            "            \"release_date\": \"2012-04-25\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 5588,\n" +
            "            \"id\": 119450,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7.2,\n" +
            "            \"title\": \"Dawn of the Planet of the Apes\",\n" +
            "            \"popularity\": 139.430614,\n" +
            "            \"poster_path\": \"/2EUAUIu5lHFlkj5FRryohlH6CRO.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Dawn of the Planet of the Apes\",\n" +
            "            \"genre_ids\": [\n" +
            "                878,\n" +
            "                28,\n" +
            "                18,\n" +
            "                53\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/t7VSsAbIQS6kpO4ikuCNSiugsSy.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"A group of scientists in San Francisco struggle to stay alive in the aftermath of a plague that is wiping out humanity, while Caesar tries to maintain dominance over his community of intelligent apes.\",\n" +
            "            \"release_date\": \"2014-06-26\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 1275,\n" +
            "            \"id\": 274855,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 5.7,\n" +
            "            \"title\": \"Geostorm\",\n" +
            "            \"popularity\": 132.619877,\n" +
            "            \"poster_path\": \"/nrsx0jEaBgXq4PWo7SooSnYJTv.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Geostorm\",\n" +
            "            \"genre_ids\": [\n" +
            "                28,\n" +
            "                878,\n" +
            "                53\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/79X8JkGxzc1tJMi0KxUSaPLooVg.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"After an unprecedented series of natural disasters threatened the planet, the world's leaders came together to create an intricate network of satellites to control the global climate and keep everyone safe. But now, something has gone wrong: the system built to protect Earth is attacking it, and it becomes a race against the clock to uncover the real threat before a worldwide geostorm wipes out everything and everyone along with it.\",\n" +
            "            \"release_date\": \"2017-10-13\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 1462,\n" +
            "            \"id\": 336843,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7.1,\n" +
            "            \"title\": \"Maze Runner: The Death Cure\",\n" +
            "            \"popularity\": 128.700076,\n" +
            "            \"poster_path\": \"/7GgZ6DGezkh3szFdvskH5XD4V0t.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Maze Runner: The Death Cure\",\n" +
            "            \"genre_ids\": [\n" +
            "                28,\n" +
            "                9648,\n" +
            "                878,\n" +
            "                53,\n" +
            "                12,\n" +
            "                14\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/bvbyidkMaBls1LTaIWYY6UmYTaL.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"Thomas leads his group of escaped Gladers on their final and most dangerous mission yet. To save their friends, they must break into the legendary Last City, a WCKD-controlled labyrinth that may turn out to be the deadliest maze of all. Anyone who makes it out alive will get answers to the questions the Gladers have been asking since they first arrived in the maze.\",\n" +
            "            \"release_date\": \"2018-01-17\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 877,\n" +
            "            \"id\": 353616,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 6.4,\n" +
            "            \"title\": \"Pitch Perfect 3\",\n" +
            "            \"popularity\": 127.215684,\n" +
            "            \"poster_path\": \"/fchHLsLjFvzAFSQykiMwdF1051.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Pitch Perfect 3\",\n" +
            "            \"genre_ids\": [\n" +
            "                35,\n" +
            "                10402\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/1qIzlhLGPSm6TxlvXBWe0Q5er7O.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"After the highs of winning the world championships, the Bellas find themselves split apart and discovering there aren't job prospects for making music with your mouth. But when they get the chance to reunite for an overseas USO tour, this group of awesome nerds will come together to make some music, and some questionable decisions, one last time.\",\n" +
            "            \"release_date\": \"2017-12-21\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 18,\n" +
            "            \"id\": 483877,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 3.8,\n" +
            "            \"title\": \"15+ IQ Krachoot\",\n" +
            "            \"popularity\": 125.847678,\n" +
            "            \"poster_path\": \"/1RxnEJzXYv5GgPszbHNsWTXPC6M.jpg\",\n" +
            "            \"original_language\": \"th\",\n" +
            "            \"original_title\": \"15 ไอคิวกระฉูด\",\n" +
            "            \"genre_ids\": [\n" +
            "                35\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/fp3Iiap1hblJfqHrBDziqgl9zzB.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"A teenage comedy film about a young Yorkie. \\\"Rising\\\" opened the first movie on screen.  The story of fun gangs of teenage age 15+ hormones gurgling at the curiosity to try on their love and sex has spread out.\",\n" +
            "            \"release_date\": \"2017-08-03\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 7341,\n" +
            "            \"id\": 245891,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7,\n" +
            "            \"title\": \"John Wick\",\n" +
            "            \"popularity\": 123.713455,\n" +
            "            \"poster_path\": \"/5vHssUeVe25bMrof1HyaPyWgaP.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"John Wick\",\n" +
            "            \"genre_ids\": [\n" +
            "                28,\n" +
            "                53\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/umC04Cozevu8nn3JTDJ1pc7PVTn.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"Ex-hitman John Wick comes out of retirement to track down the gangsters that took everything from him.\",\n" +
            "            \"release_date\": \"2014-10-22\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 3616,\n" +
            "            \"id\": 399055,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7.3,\n" +
            "            \"title\": \"The Shape of Water\",\n" +
            "            \"popularity\": 123.325154,\n" +
            "            \"poster_path\": \"/k4FwHlMhuRR5BISY2Gm2QZHlH5Q.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"The Shape of Water\",\n" +
            "            \"genre_ids\": [\n" +
            "                18,\n" +
            "                14,\n" +
            "                10749\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/abirSHwWgKajV3hXhaIR5lcCIXe.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"An other-worldly story, set against the backdrop of Cold War era America circa 1962, where a mute janitor working at a lab falls in love with an amphibious man being held captive there and devises a plan to help him escape.\",\n" +
            "            \"release_date\": \"2017-12-01\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";
}
