package com.ymhase.miniTwit;

public class AppConstant {
	
	//USERS
	public static final String IS_USER_VALID = "SELECT count(*) FROM users WHERE username = :username AND  password = :password AND deletestatus = 'A';";
	public static final String GET_USER_BY_USERNAME_PASSWORD = "SELECT * FROM users WHERE username = :username AND  password = :password AND deletestatus = 'A'";
	public static final String GET_USERNAME_BY_EMAIL = "SELECT username FROM users WHERE email = :email AND deletestatus = 'A';";
	public static final String GET_USER_BY_USERID = "SELECT * FROM users WHERE user_id = :userid AND deletestatus = 'A';";
	public static final String INSERT_USER = "INSERT INTO users (user_id, firstname, lastname, username, email, password, deletestatus) VALUES ( :userid, :firstName, :lastName, :userName, :email, :password, 'A');";
	public static final String DELETE_USER = "UPDATE users SET deletestatus = 'D' WHERE user_id = :userid ;";
	
	//Following
	public static final String FOLLOW = "INSERT INTO following (followingid, user_id, follwing_user_id, deletestatus) VALUES( :followingid, :userid, :follwinguserid, 'A');";
	public static final String UNFOLLOW = "UPDATE following SET deletestatus = 'D' WHERE user_id= :userid AND follwing_user_id = :followingID ;";
	public static final String FOLLOWER_LIST ="SELECT users.user_id AS userid, users.firstname AS firstname , users.lastname AS lastname FROM users LEFT JOIN following  ON users.user_id = following.follwing_user_id WHERE following.follwing_user_id IN (SELECT follwing_user_id from following WHERE user_id = :userid  AND deletestatus = 'A' ) AND following.deletestatus = 'A' ;";

	//SESSION
	public static final String CREATE_SESSION = "INSERT INTO session (sessionid, user_id, deletestatus) VALUES( :sessionid, :userid, 'A');";
	public static final String DELETE_SESSION = "UPDATE session SET deletestatus = 'D' WHERE sessionid= :sessionid ;";
	public static final String GET_USERID_BYSESSION = "SELECT user_id FROM session WHERE sessionid= :sessionid AND deletestatus = 'A';";
	public static final String ISSESSION_VALID = "SELECT count(*) FROM session WHERE sessionid = :sessionid AND deletestatus = 'A';";

	//TWEET
	public static final String GET_TWEET_BY_USERID ="SELECT * FROM tweet WHERE user_id = :userid AND deletestatus = 'A';";
	public static final String GET_TWEET_FOR_FOLLOWING = "SELECT tweet.user_id AS user_id , tweet.description AS description, users.firstname AS firstname , users.lastname AS lastName FROM tweet LEFT JOIN users ON users.user_id = tweet.user_id WHERE tweet.user_id IN  (SELECT follwing_user_id FROM following WHERE user_id = :userid AND deletestatus = 'A' ) AND tweet.deletestatus = 'A' ;";
	public static final String DELETE_TWEET ="UPDATE tweet SET deletestatus = 'D' WHERE tweetid = :tweetid;";
	public static final String INSERT_TWEET ="INSERT INTO tweet (tweetid, user_id, description, deletestatus) VALUES ( :tweetid, :userid, :description, :deletestatus) ;";
}
