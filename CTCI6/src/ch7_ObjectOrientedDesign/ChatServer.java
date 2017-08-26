package ch7_ObjectOrientedDesign;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ChatServer {

}

class ChatUser
{
	private int id;
	private UserStatus status = null;
	private HashMap<Integer, PrivateChat> privateChats;
	private List<GroupChat> groupChats;
	private HashMap<Integer, AddRequest> receivedAddRequest;
	private HashMap<Integer, AddRequest> sentAddRequest;
	private HashMap<Integer, ChatUser> contacts;
	private String accountName;
	private String fullName;
}

abstract class Conversation{
	private List<ChatUser> participants;
	private int id;
	private List<Message> messages;
}
class PrivateChat extends Conversation{
	
	public PrivateChat(ChatUser user1, ChatUser user2)
	{
		
	}
}

class GroupChat extends Conversation
{
	
}
class Message{
	private String content;
	private Date date;
	
}
class UserStatus{
	private UserStatusType status;
	private String message;
}

class AddRequest{
	
	private ChatUser fromUser;
	private ChatUser toUser;
	private Date date;
	private RequestStatus status;
}
enum RequestStatus{
	Rejected, Accepted, Read, Unread
}

enum UserStatusType{
	online, offline, away, busy
}
