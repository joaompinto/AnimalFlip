#!/bin/sh
LIBS_DIR=../libs

INPUT_DIR=../data/animals
OUTPUT_DIR=../../AnimalFlip-android/assets/data
PACK_FILENAME=animals

java -classpath $LIBS_DIR/gdx.jar:$LIBS_DIR/gdx-tools.jar \
	com.badlogic.gdx.tools.imagepacker.TexturePacker2 \
	$INPUT_DIR $OUTPUT_DIR $PACK_FILENAME
