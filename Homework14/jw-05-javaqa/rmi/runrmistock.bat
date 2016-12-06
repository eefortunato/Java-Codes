set OLDCLASSPATH=%CLASSPATH%
set CLASSPATH=.
start java rmistock.StockInfoImpl
echo Wait for StockInfoImpl server to be ready
pause
java rmistock.StockWatchGUI
set CLASSPATH=%OLDCLASSPATH%
set OLDCLASSPATH=

