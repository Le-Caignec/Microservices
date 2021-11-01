import flask
from flask import request, Flask
import latex2mathml.converter
from flask_cors import CORS


app = Flask(__name__)
CORS(app)


@app.route('/latex', methods=["POST"])
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
    convertion(" x = \frac {-b \pm \sqrt{b^2 - 4ac}}{2a}")
    app.run(host="localhost", port=8070)
