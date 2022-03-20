package testing;

import lombok.Getter;

@Getter
public class Account {

    private boolean active;

    public Account(){
        this.active=false;
    }

    public void active(){
        this.active=true;
    }

}
