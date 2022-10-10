4M - MULTI-MEDIA MARKETING MENU

This project was developed with Java and uses Appium/Selenium libraries for phone automation and Swing for the GUI. The phone device can be a plugged in Android Phone (I used a Pixel 3 & 3a) or even be emulated via Android Studio, which can be useful when moving to the cloud if an advanced setup is needed. Many of these details can be configured within the GUI. As of now, this is mostly functional on Windows 10, but needs to be debugged for Linux.

So far only Snapchat and Browser Actions have been automated, such as creating a new account, configuring location and adding people within that area, and even bypassing a few security measures Snapchat has implemented (don't tell them about that).

I have made appium scripts for automating these "jobs". Each job is placed in a queue and when the user is ready, they simply hit run and the jobs will execute sequentially. The GUI includes text fields for customizing each job (ie username, password, phone number) and also for configuring the environment (android studio emulator vs phone plugged in).

Lots of work needs to be put in for this application to be polished and ready for serious networking tasks, and I simply do not have the time right now to finish this. But I still believe strongly in the concept and hope to come back to it in the near future.
