from django.shortcuts import render
from django.http  import HttpResponse
from .forms import LoginForm
from django.contrib.auth.forms import AuthenticationForm


def login(response):
    if response.method == "POST":
        form = AuthenticationForm(data=response.POST)
        if form.is_valid():
            return render(response,'success.html')
        else:
            return render(response,'nosuccess.html')
    else:
        form = LoginForm()
    return render(response,"login.html",{"form":form})