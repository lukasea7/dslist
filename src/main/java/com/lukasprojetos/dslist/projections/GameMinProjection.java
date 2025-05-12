package com.lukasprojetos.dslist.projections;

public interface GameMinProjection {
    long getId();
    String getTitle();
    Integer getGameYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();
}
