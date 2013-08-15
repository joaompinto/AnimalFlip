#!/bin/sh
SOURCE_ICON=../data/app_icon.svg
LDPI=../../AnimalFlip-android/res/drawable-ldpi/ic_launcher.png
inkscape $SOURCE_ICON -e $LDPI -w 32 -h 32
MDPI=../../AnimalFlip-android/res/drawable-mdpi/ic_launcher.png
inkscape $SOURCE_ICON -e $MDPI -w 48 -h 48
HDPI=../../AnimalFlip-android/res/drawable-hdpi/ic_launcher.png
inkscape $SOURCE_ICON -e $HDPI -w 72 -h 72
