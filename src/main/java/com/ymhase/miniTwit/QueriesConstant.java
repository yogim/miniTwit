package com.ymhase.miniTwit;

public class QueriesConstant {
	
	//USERS
	public static final String isvalidUser = "SELECT count(*) FROM users WHERE username = :username AND  password = :password AND deletestatus = 'A';";
	public static final String getUserByUernamePassword = "SELECT * FROM users WHERE username = :username AND  password = :password AND deletestatus = 'A'";
	public static final String getUsernameByEmail = "SELECT username FROM users WHERE email = :email AND deletestatus = 'A';";
	public static final String getUserByUserId = "SELECT * FROM users WHERE user_id = :userid AND deletestatus = 'A';";
	public static final String insertUser = "INSERT INTO users (user_id, firstname, lastname, username, email, password, deletestatus) VALUES ( :userid, :firstName, :lastName, :userName, :email, :password, 'A');";
	public static final String deleteUser = "UPDATE users SET deletestatus = 'D' WHERE user_id = :userid ;";
	
	//Following
	public static final String follow = "INSERT INTO following (followingid, user_id, follwing_user_id, deletestatus) VALUES( :followingid, :userid, :follwinguserid, 'A');";
	public static final String unfollow = "UPDATE following SET deletestatus = 'D' WHERE user_id= :userid AND follwing_user_id = :followingID ;";
	public static final String followerList ="SELECT users.user_id AS userid, users.firstname AS firstname , users.lastname AS lastname FROM users LEFT JOIN following  ON users.user_id = following.follwing_user_id WHERE following.follwing_user_id IN (SELECT follwing_user_id from following WHERE user_id = :userid  AND deletestatus = 'A' ) AND following.deletestatus = 'A' ;";

	//SESSION
	public static final String createSession = "INSERT INTO session (sessionid, user_id, deletestatus) VALUES( :sessionid, :userid, 'A');";
	public static final String deleteSession = "UPDATE session SET deletestatus = 'D' WHERE sessionid= :sessionid ;";
	public static final String getUserIDBySessionID = "SELECT user_id FROM session WHERE sessionid= :sessionid AND deletestatus = 'A';";
	public static final String isSessionValid = "SELECT count(*) FROM session WHERE sessionid = :sessionid AND deletestatus = 'A';";

	//TWEET
	public static final String getTweetbyUserID ="SELECT * FROM tweet WHERE user_id = :userid AND deletestatus = 'A';";
	public static final String getTweetForFollowing = "SELECT tweet.user_id AS user_id , tweet.description AS description, users.firstname AS firstname , users.lastname AS lastName FROM tweet LEFT JOIN users ON users.user_id = tweet.user_id WHERE tweet.user_id IN  (SELECT follwing_user_id FROM following WHERE user_id = :userid AND deletestatus = 'A' ) AND tweet.deletestatus = 'A' ;";
	public static final String deleteTweet ="UPDATE tweet SET deletestatus = 'D' WHERE tweetid = :tweetid;";
	public static final String insertTweet ="INSERT INTO tweet (tweetid, user_id, description, deletestatus) VALUES ( :tweetid, :userid, :description, :deletestatus) ;";
}
