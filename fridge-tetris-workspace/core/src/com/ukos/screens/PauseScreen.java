package com.ukos.screens;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.ukos.screens.TransluscentMenuScreen.Event;
import com.ukos.tween.ActorAccessor;

public class PauseScreen extends TransluscentMenuScreen {

	public PauseScreen(Stage stage, Skin skin) {
		super(stage, skin);
	}
	@Override
	protected void setStrings() {
		headerText = "Game Paused";
		backButtonText = "Back";
	}
	@Override
	protected Event getBackEvent() {
		return Event.BACK_CLICK;
	}
	@Override
	public void fadeOut() {
		Timeline.createSequence().beginSequence()
		.push(Tween.to(table, ActorAccessor.ALPHA, .25f).target(0))
		.push(Tween.set(table, ActorAccessor.VISIBILITY).target(0.0f))
		.end().start(tweenManager).setCallback(new TweenCallback() {
			
			@Override
			public void onEvent(int type, BaseTween<?> source) {
//				GameScreen.releasePause();
				setEvent(Event.FADE_OUT_PAUSE);
			}
		});
		
		tweenManager.update(Gdx.graphics.getDeltaTime());
//		table.setVisible(false);
	}
	
	

}