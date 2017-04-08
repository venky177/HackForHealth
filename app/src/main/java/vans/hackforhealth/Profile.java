package vans.hackforhealth;

/**
 * Created by saura on 4/8/2017.
 */

public class Profile {
    private String _name;
    private String _author;

    public Profile(String name, String auth)
    {
        this._name = name;
        this._author = auth;
    }

    public String getName()
    {
        return _name;
    }

    public void setName(String name)
    {
        this._name = name;
    }

    public String getAuthor()
    {
        return _author;
    }

    public void setAuthor(String auth)
    {
        this._author = auth;
    }
}
