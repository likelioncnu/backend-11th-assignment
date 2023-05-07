package hello.servlet;

import lombok.Getter;
import lombok.Setter;

@lombok.Data
@Getter
@Setter
public class Data {
    int bunMo;
    int bnuJa;
    int result;
    public Data(int bunMo, int bnuJa, int result) {
        this.bunMo = bunMo;
        this.bnuJa = bnuJa;
        this.result = result;
    }
}
