package com.example.xmlformat

import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.InputStream

class XmlStudentData {

    private val students = ArrayList<StudentDetails>()

    private var text = ""
    private var stId= 0
    private var stName = ""
    private var stGrade = 0F

    fun parse(inputStream: InputStream): List<StudentDetails> {
        try {
            val factory = XmlPullParserFactory.newInstance()
            val parser = factory.newPullParser()
            parser.setInput(inputStream, null)
            var eventType = parser.eventType
            while (eventType != XmlPullParser.END_DOCUMENT) {
                val tagName = parser.name
                when (eventType) {
                    XmlPullParser.TEXT -> text = parser.text
                    XmlPullParser.END_TAG -> when {
                        tagName.equals("id",true)-> {
                            stId = text.toInt()
                        }
                        tagName.equals("name", true) -> {
                            stName = text.toString()
                        }
                        tagName.equals("grade", ignoreCase = true) -> {
                            stGrade = text.toFloat()
                        }
                        else -> students.add(StudentDetails(stId,stName, stGrade))
                    }

                    else -> {
                    }
                }
                eventType = parser.next()
            }

        } catch (e: XmlPullParserException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return students
    }


}