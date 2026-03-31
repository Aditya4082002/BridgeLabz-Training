package linkedList;

// Friend Node (nested linked list)
class FriendNode {
    int friendId;
    FriendNode next;

    public FriendNode(int friendId) {
        this.friendId = friendId;
    }
}

// User Node
class UserNode {
    int userId;
    String name;
    int age;
    FriendNode friends; // head of friend list
    UserNode next;

    public UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
    }
}

// Singly Linked List for Users
class SocialMedia {
    UserNode head;

    // add new user
    public void addUser(int id, String name, int age) {
        UserNode newUser = new UserNode(id, name, age);
        newUser.next = head;
        head = newUser;
    }

    // add friend connection (bidirectional)
    public void addFriend(int userId1, int userId2) {
        UserNode u1 = findUserById(userId1);
        UserNode u2 = findUserById(userId2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found.");
            return;
        }

        addFriendToList(u1, userId2);
        addFriendToList(u2, userId1);

        System.out.println("Friend connection added.");
    }

    // remove friend connection
    public void removeFriend(int userId1, int userId2) {
        UserNode u1 = findUserById(userId1);
        UserNode u2 = findUserById(userId2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found.");
            return;
        }

        removeFriendFromList(u1, userId2);
        removeFriendFromList(u2, userId1);

        System.out.println("Friend connection removed.");
    }

    // find mutual friends
    public void findMutualFriends(int userId1, int userId2) {
        UserNode u1 = findUserById(userId1);
        UserNode u2 = findUserById(userId2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found.");
            return;
        }

        FriendNode f1 = u1.friends;
        boolean found = false;

        System.out.println("Mutual Friends:");
        while (f1 != null) {
            if (isFriend(u2.friends, f1.friendId)) {
                System.out.println("User ID: " + f1.friendId);
                found = true;
            }
            f1 = f1.next;
        }

        if (!found) {
            System.out.println("No mutual friends.");
        }
    }

    // display friends of a user
    public void displayFriends(int userId) {
        UserNode user = findUserById(userId);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of " + user.name + ":");
        FriendNode temp = user.friends;

        if (temp == null) {
            System.out.println("No friends.");
            return;
        }

        while (temp != null) {
            System.out.println("Friend ID: " + temp.friendId);
            temp = temp.next;
        }
    }

    // search by user ID
    public void searchById(int userId) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                displayUser(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("User not found.");
    }

    // search by name
    public void searchByName(String name) {
        UserNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                displayUser(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("User not found.");
        }
    }

    // count friends for each user
    public void countFriends() {
        UserNode temp = head;

        while (temp != null) {
            int count = 0;
            FriendNode f = temp.friends;

            while (f != null) {
                count++;
                f = f.next;
            }

            System.out.println(temp.name + " has " + count + " friends.");
            temp = temp.next;
        }
    }

    // ================= HELPER METHODS =================

    private UserNode findUserById(int id) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == id)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    private void addFriendToList(UserNode user, int friendId) {
        if (isFriend(user.friends, friendId))
            return;

        FriendNode newFriend = new FriendNode(friendId);
        newFriend.next = user.friends;
        user.friends = newFriend;
    }

    private void removeFriendFromList(UserNode user, int friendId) {
        FriendNode temp = user.friends;
        FriendNode prev = null;

        while (temp != null && temp.friendId != friendId) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null)
            return;

        if (prev == null)
            user.friends = temp.next;
        else
            prev.next = temp.next;
    }

    private boolean isFriend(FriendNode head, int friendId) {
        while (head != null) {
            if (head.friendId == friendId)
                return true;
            head = head.next;
        }
        return false;
    }

    private void displayUser(UserNode user) {
        System.out.println("User ID : " + user.userId);
        System.out.println("Name : " + user.name);
        System.out.println("Age : " + user.age);
        System.out.println("--------------------");
    }
}

// Main class
public class SocialMediaFriendSystem {

    public static void main(String[] args) {

        SocialMedia sm = new SocialMedia();

        sm.addUser(1, "Aditya", 22);
        sm.addUser(2, "Rahul", 21);
        sm.addUser(3, "Aman", 23);
        sm.addUser(4, "Neha", 20);

        sm.addFriend(1, 2);
        sm.addFriend(1, 3);
        sm.addFriend(2, 3);
        sm.addFriend(3, 4);

        sm.displayFriends(1);

        sm.findMutualFriends(1, 2);

        sm.removeFriend(1, 2);

        sm.displayFriends(1);

        sm.searchByName("Aman");

        sm.countFriends();
    }
}
