package com.game.Constants;

public final class PlayerConstants {

    private static final int basePlayerWidth = 40;
    private static final int basePlayerHeight = 40;

    public static final double playerHeight = basePlayerHeight * ScreenConstants.scale;
    public static final double playerWidth = basePlayerWidth * ScreenConstants.scale;

    private static final double basePlayerSpeed = 100;
    public static final double playerSpeed = basePlayerSpeed * ScreenConstants.scale / ScreenConstants.FPS;
    
}
