#! /bin/bash

echo "**********"
echo "Moving files to /opt/"
echo "**********"
cp -rv ../HamJournal /opt/
echo "**********"
echo "Complete"
echo "**********"
echo "Permissions for UserSpace"
echo "**********"
chmod -Rv /opt/HamJournal/UserSpace/
echo "**********"
echo "Creating Terminal Start"
echo "**********"
sudo ln -s /opt/HamJournal/hamjournal.sh /usr/bin/hamjournal
sudo chmod +x /opt/HamJournal/hamjournal.sh
echo "**********"
echo "Making uninstall script executable"
echo "**********"
sudo chmod +x /opt/HamJournal/uninstall.sh
echo "**********"
echo "Complete"
echo "**********"


echo "Done!"

