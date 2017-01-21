package com.projects.ujjwal.techism.STT.Presenter;

import com.projects.ujjwal.techism.STT.Model.Data.SttResponse;
import com.projects.ujjwal.techism.STT.Model.SttHelper;
import com.projects.ujjwal.techism.STT.SttCallback;
import com.projects.ujjwal.techism.STT.View.SttView;

/**
 * Created by ujjwal on 20/1/17.
 */
public class SttPresenterImpl implements SttPresenter {
	private SttView sttView;
	private SttHelper sttHelper;

	public SttPresenterImpl(SttView sttView, SttHelper sttHelper) {
		this.sttView = sttView;
		this.sttHelper = sttHelper;
	}

	@Override
	public void getUserInput(String object) {
		sttHelper.getUserInput(object, new SttCallback() {
			@Override
			public void onSuccess(SttResponse sttResponse) {
				if (sttResponse.isSuccess()){
				sttView.showMessage(sttResponse.getMessage());

				}
			}

			@Override
			public void onFailure(String message) {
				sttView.showMessage(message);
			}
		});
	}
}
