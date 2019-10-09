package com.example.parxsys.base;


public class BaseRepository {

    private LoadingElements loadingElements;

    public void setLoadingElements(LoadingElements loadingElements) {
        this.loadingElements = loadingElements;
    }


    public void showLoading(String message) {
        if (loadingElements != null) {
            loadingElements.showLoading(message);
        }
    }

    public void hideLoading() {
        if (loadingElements != null) {
            loadingElements.hideLoading();
        }
    }

    public void showToast(String message) {
        if (loadingElements != null) {
            loadingElements.showToast(message);
        }
    }

    public void endScreen(){
        if(loadingElements !=null){
            this.loadingElements.endScreen();
        }

    }
    public void showAlert(String message){
        if(loadingElements !=null){
            this.loadingElements.showAlert(message);
        }

    }


}
