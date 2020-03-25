package masnin.thibaut.tpfinal.Adapter;

import java.util.List;

import masnin.thibaut.tpfinal.Model.Pays;

public interface MyService {
    @GET("pays")
    Call<List<Pays>> getPays();
}
