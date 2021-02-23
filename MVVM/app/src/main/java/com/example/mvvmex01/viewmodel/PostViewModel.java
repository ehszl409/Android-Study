package com.example.mvvmex01.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmex01.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostViewModel extends ViewModel {

    // LiveData(변화가 없는 데이터), MutableLiveDate(변화 하는 데이터)
    // LiveDate는 서버에 요청을해서 데이터를 변경한다.
    // 공통점 데이터를 변경하면 UI가 자동으로 변경된다.
    // 서버 에서 데이터를 다운 받아서 저장해준다.
    private MutableLiveData<List<Post>> mtPosts = new MutableLiveData<>();


    public MutableLiveData<List<Post>> 구독(){
        return mtPosts;
    }

    public void 포스트한건추가(Post post){
        List<Post> posts = mtPosts.getValue();
        posts.add(post);
        mtPosts.setValue(posts);
    }

    //
    public void 포스트변경(){
        List<Post> posts = mtPosts.getValue();
        posts.get(0).setTitle("테스트");
        mtPosts.setValue(posts);
    }

    public void 데이터초기화(){
        List<Post> posts = new ArrayList<>();
        mtPosts.setValue(posts);
    }
}
