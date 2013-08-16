#!/bin/sh
SOURCE_ICON=../data/app_icon.svg
LDPI=../../AnimalFlip-android/res/drawable-ldpi/ic_launcher.png
inkscape $SOURCE_ICON -e $LDPI -w 32 -h 32
DESKTOP=../../AnimalFlip-android/assets/data/
cp -v $LDPI $DESKTOP
MDPI=../../AnimalFlip-android/res/drawable-mdpi/ic_launcher.png
inkscape $SOURCE_ICON -e $MDPI -w 48 -h 48
HDPI=../../AnimalFlip-android/res/drawable-hdpi/ic_launcher.png
inkscape $SOURCE_ICON -e $HDPI -w 72 -h 72
HRES=../../AnimalFlip-android/data/appicon_hires.png
#inkscape $SOURCE_ICON -e $HRES -w 512 -h 512

