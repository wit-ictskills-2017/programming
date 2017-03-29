import java.util.ArrayList;

/**
 * This class stores information about a post in a social network news feed. 
 * The main part of the post consists of a (possibly multi-line)
 * text message. Other data, such as author and time, are also stored.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 0.2
 */
public class MessagePost extends Post
{
    private String message;  // an arbitrarily long, multi-line message

    /**
     * Constructor for objects of class MessagePost.
     * 
     * @param author    The username of the author of this post.
     * @param text      The text of this post.
     */
    public MessagePost(String author, String text)
    {
        super(author);
        message = text;
    }

    /**
     * Return the text of this post.
     * 
     * @return The post's message text.
     */
    public String getText()
    {
        return message;
    }
    /**
     * return a String of the entire object
     * @return A string version of the post
     */
    public String display()
    {
        return super.display() + "\n" + message;
    }
    /**
     * return a short extract of the post message
     * @return A string containing the first 10 chars of the post
     */
    String displayExtract()
    {
        return "Message extract "+ message.substring(0,10) + "....";
    }
}
