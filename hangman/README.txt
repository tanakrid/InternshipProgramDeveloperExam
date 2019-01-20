# InternshipProgramDeveloperExam
for submit project exam
Full name: Tanakrid Chanburi 
Email: Tanakrid.c@ku.th
Number: 0852520798

How to compile, run and build (hangman) 
ใช้งานโปรแกรม Intellij IDEA ในการ compile, run and build

1.สร้างโปรเจคสำหรับการ build

2.นำไฟล์ hangman ไปวางในโปรเจคที่สร้างเตรียมไว้

3.จากข้อ2 สามารถทำการ compile and run ได้จากฟังก์ชั่นที่ intellij IDEA เตรียมไว้ได้เลย นั่นคือจะมีปุ่มสำหรับรันหรือคลิกขวาแล้วเลือกรันได้เลย

4.เมื่อทำการ build สามารถทำตามขั้นตอนต่อไปนี้ได้เลย 
	file->project structure->project setting->artifacts->ปุ่มเครื่องหมาย "+"
	->JAR->from module with dependencies..
	->เลือก main method(ในที่นี้มี main method เดียว)->ok->ok
	->build->build artifacts->build
  เมื่อทำการ build แล้วจะได้เป็นไฟล์ .jar ซึ่งจะถูกเก็บไว้ที่ folder production

5.เมื่อจะทำการรัน ให้นำ folder Vocab ที่ได้แนบไปนำมาวางไว้ใน directoryเดียวกับที่เก็บ .jar

6.แล้วเปิดไฟล์.jarด้วย command promt or terminal

7.ใช้คำสั่ง java -jar <ชื่อไฟล์.jar>.jar

8.สามารถใช้งานโปรแกรม hangman

