#!/usr/bin/python
import subprocess

from flask import Flask, request

app = Flask("RailIl")

#/rail?outfomate=html&startS=Binyamina&lastS=Modiin&hour=10&minutes=12
#that waht we need to writh to this in after the URL for working

@app.route("/rail")
def rail_schedule():
    if 'outformat' in request.args:
        outformat = request.args.get('outformat')
    else:
        outformat = "html"

    if 'startS' in request.args :
        startS = request.args.get('startS')
    else:
        startS ='null'

    if 'lastS' in request.args:
        lastS = request.args.get('lastS')
    else:
        lastS = 'null'

    if 'hour' in request.args:
        hour = request.args.get('hour')
    else:
        hour = 'null'

    if 'minutes' in request.args:
        minutes = request.args.get('minutes')
    else:
        minutes = 'null'


    return subprocess.check_output(["java", "-classpath", "/home/shachar/git/railIL/bin", "main/main", outformat
                                   ,startS , lastS , hour, minutes])



