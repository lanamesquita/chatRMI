javac -d bin -cp src/ src/Chat.java src/ChatClient.java
cd bin && rmic Chat && cd ..
java -cp /home/lana/workspaceChat/SimpleChatClient/bin -Djava.security.policy=client.policy ChatClient