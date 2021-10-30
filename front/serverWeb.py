import os
from http.server import HTTPServer, CGIHTTPRequestHandler

os.chdir('.')
server_object = HTTPServer(server_address=('127.0.0.1', 8080), RequestHandlerClass=CGIHTTPRequestHandler)
server_object.serve_forever()