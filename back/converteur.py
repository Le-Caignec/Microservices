import flask
from flask import request, Flask
import markdown
from flask_cors import CORS


app = Flask(__name__)
CORS(app)


@app.route('/convert', methods=["POST"])
def handlePost():
    recive=request.get_json()
    print(recive.get("a"))
    converted = convertion(recive.get("a"))
    data = {}
    data["convert"] = converted
    return flask.jsonify(data)

def convertion(input_text):
    html = markdown.markdown(input_text)
    return html

if __name__ == '__main__':
    app.run(host="localhost", port=8060)
