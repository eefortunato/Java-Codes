set OLDCLASSPATH=%CLASSPATH%
set CLASSPATH=.
javac -d . *.java
rmic -d . rmistock.StockInfoImpl rmistock.StockWatchGUI rmistock.StockWatchText
set CLASSPATH=%OLDCLASSPATH%
set OLDCLASSPATH=

