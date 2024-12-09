This program serves as a test of the gRPC protocal developed by Google.

The application is structured as a command line tool capable of both sending gRPC requests, and initiating a server to recieve those requests.
It simulates a student registering for classes, either CS158A or CS 158B. 

The protobufs file defines the possible functions and results of calling those functions.

The program uses ConcurrentHashmaps to store data in memory in a thread safe way, because the gRPC server creates a thread for each request, which may overwrite eachother.
