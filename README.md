#Ham Journal

**Contents** 
* [Overview]
* [Purpose]
* [Development Notes]
* [Future updates]
* [Set-up]
* [Program Files Information]
* [Machines tested on]
* [Trouble shooting]
* [Contributing]
* [How to contribute]
* [Contact us]

#Overview
**Ham Journal** is a free and opened sourced application developed in Java that I am developing while I am in the process of learning to program in the language. This application is meant to be a simple tool for ham radio operators to use. In it's current state, it is meant as a program for operators to log their daily activities in a way that perhaps isn't being covered in their contact log book. This is a work in progress, so there will be more features and better implementation in the future. 

#Development Notes
This application is programmed in Java 1.8. So far it has only been tested on my system which runs Debian 9.2. While this Program has had many changes in my development environment, this is the first public release.

#Future updates
The following are what changes will be made in the future.
* Update system
* Menu bar
* Windows Version
* Creation of other needed user defined settings
* Retreive when an entry was last modified.
* Station notes that will allow users to log any changes to their station or equipment.
* Port into Android and possibly iOS (dependant on amount of requests).

#Set-up
Run the set-up script using sudoer's permission by navigating to where the downloaded HamJournal folder is located in the terminal. execute the following command in terminal:

sudo ./setup.sh

If that fails, run:

chmod +x setup.sh
sudo ./setup.sh

This will allow HamJournal to set up program files in the /opt directory. These files can be found in /opt/HamJournal/. 

#Program Files Information
Most files will be contained within the /opt/HamJournal/ directory. There will be a folder named "UserSpace." Under UserSpace is currently two folders, "Profiles" and "Journal." All profiles will automatically be serialized (saved) into the /opt/HamJournal/UserSpace/Profiles/ directory. Some linux distributions require sudo to write to this path. So it is recommended to always run HamJournal with sudo, or to edit folder permissions to allow for user write and read. 

Journal enteries may be saved in the /opt/HamJournal/UserSpace/Journal/ directory. However, when creating a new User, you are allowed to set your own directory listing. Just be sure that is exists. So for instance, you may choose /home/foo/MyJournalEnteries/. This path is hand written in by user. 

If a profile needs to be deleted, smimply navigate to the /opt/HamJournal/UserSpace/Profiles/ directory in terminal and execute: 

sudo rm profileName

Now, through HamJournal application, create a new user. 

One final note on the journal path. If there are multiple users on the same system, it is heavily recommended to place enteries in seperate folders. As mentioned above, you may create your own. If you wish to stick with the provided path, simply navigate to /opt/HamJournal/UserSpace/Journal/ in the terminal and execute the following command:

sudo mkdir foo

Source code will be provided in the /opt/HamJournal/src/ folder.

#Machines tested on
* Debian 9.2 running openjdk version "1.8.0_141"
OpenJDK Runtime Environment (build 1.8.0_141-8u141-b15-1~deb9u1-b15)


#Trouble shooting
If you are experiencing issues with this application, there is a checklist of things to do. What you choose to do is based on your comfortability. Especially since the only system this has been tested on is my own, running Debian, and with me, the programmer, at the helm of my system to fix the issues I am having. So what are the options?

1. Read the Trouble Shooting text file, it may cover your issue.
2. Go down to the contact section and email, in the most descriptive way, what is happening with Ham Journal on your machine. Be sure to include what operating system you are running. Tell me how you installed and set-up Ham Journal. As much detail as possible always helps.
3. Go to the forum and post as much information about your issue. I, or someone else will do our best to help.
4. If you are comfortable with compiling from source code, download the source code and open it as an exising project in an IDE like eclipse and run from there. Make changes to source code as needed. Once it works, go to the [How to contribute] and tell us what you did so perhaps your specific issue can be mitigated in future updates. 

#Contributing
At the end of the day, it isn't myself who makes the program better, it is the users. That is how opened sourced works. Right now the development in Ham Journal is only going down a path of implementing tools that I know I could get use out of it, but if it is missing something, let me know! As long as it is within my capabilities, I will put it on a list of future additions to be released. 

#How to contribute
There are many ways. If you are a programmer, take a look at the source code that will be hosted on github. Help make changes to the program by submitting in code.

Even if your not computer savvy with Java, or have no interest in programming, send me an email on what you would like to see, or what could be done better. Or even email me bits of code to look over.

Another way to contribute is with money. The software is free and opened source for everyone to use. However, if you enjoy this software, or think the idea behind it can deliver tools you may see as invaluable, please contribute with donations. Donations will go to support me spending more time on this and potential future services like migrating it on andoird, iOS, and even doing back ups so you can move data online between systems.

See the Contact Me section for contributions, or post to github. 

#Contact Me
Email is KJ4NTV@gmail.com
