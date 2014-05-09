#!/bin/bash
NRO=${0:(-1)}
#CP="/usr/share/java/junit.jar:."
CP="../hamcrest-core.jar:../junit.jar:."
JAVAC_OPTS="-source 1.7 -g"
JAVA_OPTS_TESTS="-ea"

function make() {
	cd ..
	SRCS1=`find Ejercicio${NRO}/ -name '*.java'`
	SRCS=''
	for SRC in $SRCS1; do
		OBJ=${SRC/\.java/.class}
		if [ "$SRC" -nt "$OBJ" ]; then
			SRCS="$SRCS ${SRC}"
		fi
	done

	if [ "$SRCS" != "" ]; then
		echo "Compilando Ejercicio ${NRO}"
		javac $JAVAC_OPTS -cp "${CP}" ${SRCS}
	fi
	cd Ejercicio${NRO}
}

function clean() {
	find . -name '*.class' -exec rm {} \;
}

function tests() {
	(cd .. &&	java $JAVA_OPTS_TESTS -cp "$CP" org.junit.runner.JUnitCore Ejercicio${NRO}.tests.Exercise${NRO}Tests)
}

function run() {
	(cd .. && java -cp "$CP" Ejercicio${NRO}.main.Main)
}

function benchmark() {
	(cd .. && java -Xbatch -cp "$CP" Ejercicio${NRO}.casos.Generador $1 $2 $3 $4)
}

if [ $# -eq 0 ]; then
	run
fi

while [ $# -gt 0 ]; do
	case $1 in
		'make') make;;
		'clean') clean;;
		'tests') tests;;
		'benchmark'|'bench')
			shift 1
			benchmark "$@"
			shift 3
			;;
		'run'|'') run;;
		'help'|*) echo "Uso: $0 make|clean|tests|run|help|benchmark";;
	esac
	shift 1
done
