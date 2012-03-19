package createzip


class ZipController {

	def directory = {
		def directory = params['dir']
		def filename = params['filename']
		def stripdir = params['stripdir']?:""
		response.setHeader("Content-disposition", "attachment; filename=\"" + filename + "\"");
		response.setContentType("application/zip")
		ZipFile.leftShift(response.outputStream, directory, stripdir)
		// log.debug response
	}
}
