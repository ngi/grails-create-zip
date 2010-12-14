package createzip


class ZipController {

	def directory = {
		def directory = params['dir']
		def filename = params['filename']
		response.setHeader("Content-disposition", "attachment; filename=\"" + filename + "\"");
		response.setContentType("application/zip")
		ZipFile.leftShift(response.outputStream, directory)
		log.debug response
	}
}