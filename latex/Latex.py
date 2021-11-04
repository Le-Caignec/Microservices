import flask
from flask import request, Flask
import latex2mathml.converter
from flask_cors import CORS


app = Flask(__name__)
CORS(app)


@app.route('/convertTOlatex', methods=["POST"])
def handlePost():
    recive=request.get_json()
    print(recive.get("a"))
    converted = convertion(recive.get("a"))
    data = {}
    data["convert"] = converted
    return flask.jsonify(data)

def convertion(input_text):
    html = latex2mathml.converter.convert(input_text)
    print(html)
    return html

if __name__ == '__main__':
    app.run(host="0.0.0.0", port=8070)
