package lesson5.api;

import retrofit2.Call;
import retrofit2.http.*;


public interface CategoryService {

    @GET("categories/{id}")
    Call<GetCategoryResponse> getCategory(@Path("id") int id);
}
