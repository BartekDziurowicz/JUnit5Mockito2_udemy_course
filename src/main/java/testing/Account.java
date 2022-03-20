package testing;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Account {

    private boolean active;
    @Setter
    private Address defaultDeliveryAddress;

    public Account(){
        this.active=false;
    }

    public void active(){
        this.active=true;
    }

}
