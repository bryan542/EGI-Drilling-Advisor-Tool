package Executable;

import org.jscience.physics.amount.Amount;

import javax.measure.quantity.Pressure;
import javax.measure.unit.*;

public class jsciencetest {


    public jsciencetest(){

        Amount<Pressure> sigma1 = Amount.valueOf(4000, SI.PASCAL);
        sigma1 = sigma1.times(.000145038);
        System.out.println(sigma1);

    }

    public static void main(String[] args) {
        jsciencetest jct = new jsciencetest();
    }
}
