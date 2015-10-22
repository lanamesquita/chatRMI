javac -d bin -cp src/ src/Chat.java src/ChatServer.java
cd bin && rmic Chat && cd ..
java -cp /home/lana/workspaceChat/SimpleChatServer/bin -Djava.security.policy=server.policy ChatServer