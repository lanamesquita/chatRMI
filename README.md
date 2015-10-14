# chatRMI
Um chat em java RMI.


rmic CalculatorServer 
On the Solaris Operating System:

java -classpath classDir -Djava.rmi.server.codebase=file:classDir/ example.hello.Server &
On Windows platforms:

start java -classpath classDir -Djava.rmi.server.codebase=file:classDir/ example.hello.Server
