package createzip
import java.util.zip.ZipEntry
import java.io.File
import java.io.FileInputStream
import java.util.zip.ZipOutputStream

class ZipFile
{
  def static leftShift(OutputStream out, String zipDir)
  {
	
	ZipOutputStream zos = new ZipOutputStream(out)	
	zapDir(zipDir, zos)
	zos.close()
  }
  
  def static zapDir(String dir2zip, ZipOutputStream zos) 
  {
	  File zipDir = new File(dir2zip)
	  def dirList = zipDir.list()
	  byte[] readBuffer = new byte[2156]
	  int bytesIn = 0
	  dirList.each {
		  File f = new File(zipDir, it)
		  if(f.isDirectory())
		  	zipDir(f.path, zos)
		  else {
			  FileInputStream fis = new FileInputStream(f)
			  ZipEntry anEntry = new ZipEntry(f.path)
			  zos.putNextEntry(anEntry)
			  while((bytesIn = fis.read(readBuffer)) != -1)
			  {
				  zos.write(readBuffer, 0, bytesIn);
			  }
			  fis.close();
		  }
	  }	
   }
}
