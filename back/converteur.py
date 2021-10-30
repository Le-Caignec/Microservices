import flask
from flask import Flask
import markdown
from flask_cors import CORS


app = Flask(__name__)
CORS(app)


@app.route('/convert', methods=["GET"])
def handlePost():
    print("j'ai bien recu un post")
    converted = "hello world"
    response = flask.jsonify(some = converted)
    print(response)
    return response

def convertion():
    with open('exemple.md', 'r') as f:
        text = f.read()
        html = markdown.markdown(text)
    return html

if __name__ == '__main__':
    app.run(host="localhost", port=8060)
