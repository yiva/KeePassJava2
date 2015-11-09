package org.linguafranca.db.base;

import org.linguafranca.db.Entry;
import org.linguafranca.db.Group;

/**
 * Base implementation of Entry
 *
 * @author Jo
 */
public abstract class AbstractEntry implements Entry {

    @Override
    public  boolean matchTitle(String text){
        return (getTitle().toLowerCase().contains(text.toLowerCase()));
    }

    @Override
    public  boolean matchNotes(String text){
        return (getNotes().toLowerCase().contains(text.toLowerCase()));
    }

    @Override
    public  boolean matchUsername(String text){
        return (getUsername().toLowerCase().contains(text.toLowerCase()));
    }

    @Override
    public  boolean matchUrl(String text){
        return (getUrl().toLowerCase().contains(text.toLowerCase()));
    }

    @Override
    public boolean match(String text) {
        return matchTitle(text) || matchNotes(text) || matchUrl(text) || matchUsername(text);
    }

    @Override
    public boolean match(Entry.Matcher matcher) {
        return matcher.matches(this);
    }

    @Override
    public String getPath() {
        Group parent = this.getParent();
        String result = "";
        if (parent != null) {
            result = parent.getPath();
        }
        return result + getTitle();
    }

    public String toString() {
        return this.getPath();
    }
}