#!/bin/sh
SOURCE_ICON=../data/app_icon.svg

# Android related icons
icons="l32 m48 h72"
for icon in $icons
do
	res_letter=$(echo $icon|cut -b1)
	res_size=$(echo $icon|cut -b2-)
	convert $SOURCE_ICON -resize ${res_size}x${res_size} \
		../../AnimalFlip-android/res/drawable-${res_letter}dpi/ic_launcher.png
done
HRES=../../AnimalFlip/data/appicon_hires.png
convert $SOURCE_ICON -resize 512x512! $HRES

# Desktop icons
icons="128 32 16"
for size in $icons
do
	convert $SOURCE_ICON -resize ${size}x${size} \
		../../AnimalFlip-android/assets/data/ic_launcher_${size}.png
done
