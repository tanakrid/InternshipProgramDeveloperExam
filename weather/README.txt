# InternshipProgramDeveloperExam
for submit project exam
Full name: Tanakrid Chanburi 
Email: Tanakrid.c@ku.th
Number: 0852520798

How to compile, run and build (weather) 
ใช้งานโปรแกรม Intellij IDEA ในการ compile, run and build

1.สร้างโปรเจคสำหรับการ build

2.ทำการติดตั้ง libary 3rd party ใน Intellij IDEA project
	recource package: https://github.com/stleary/JSON-java
	2.1 สามารถปฏิบัติตามขั้นตอนการติดตั้ง external JARs บน Intellij IDEA ได้ดังนี้ 
	File->Project Structure->Module->Dependencies tab->กดปุ่มเครื่องหมาย"+"->JARs or directories

3.นำไฟล์  weather ไปวางในโปรเจคที่สร้างเตรียมไว้ 

4.จากข้อ2 สามารถทำการ compile and run ได้จากฟังก์ชั่นที่ intellij IDEA เตรียมไว้ได้เลย นั่นคือจะมีปุ่มสำหรับรันหรือคลิกขวาแล้วเลือกรันได้เลย

5.เมื่อทำการ build สามารถทำตามขั้นตอนต่อไปนี้ได้เลย 
	file->project structure->project setting->artifacts->ปุ่มเครื่องหมาย "+"
	->JAR->from module with dependencies..
	->เลือก main method(ในที่นี้มี main method เดียว)->ok->ok
	->build->build artifacts->build
  เมื่อทำการ build แล้วจะได้เป็นไฟล์ .jar ซึ่งจะถูกเก็บไว้ที่ folder production

6.สร้าง folder OutputInputFile สำหรับเป็นโฟล์เดอร์ที่จะเก็บไฟล์output input มาวางไว้ใน directoryเดียวกับที่เก็บ .jar

7.แล้วเปิดไฟล์.jarด้วย command promt or terminal

8.ใช้คำสั่ง java -jar <ชื่อไฟล์.jar>.jar

9.สามารถใช้งานโปรแกรม weather

แหล่งที่มา:
https://stackoverflow.com/questions/1823264/quickest-way-to-convert-xml-to-json-in-java
https://github.com/stleary/JSON-java
https://docs.google.com/presentation/d/1qtmv6mLawRoDaCq-DDlts9rh1qPBBMG9wnDkcsUr-qM/edit#slide=id.g46e2fe4e9c_0_6
https://stackoverflow.com/questions/1051640/correct-way-to-add-external-jars-lib-jar-to-an-intellij-idea-project
