set -e
cd "$(dirname "$0")"
mkdir -p bin
find ./src -name *.java | javac -d bin -classpath "./antlr-4.7.1-complete.jar" @/dev/stdin
