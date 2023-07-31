class Target {
    constructor(targetImage, posX, posY, width, height) {
    this.targetImage = targetImage;
    this.posX = posX;
    this.posY = posY;
    this.width = width;
    this.height = height;
  }
  /** 타겟을 그려라. 타겟의 위치 정보 */
  draw(ctx) {
    ctx.drawImage(this.targetImage, this.posX, this.posY, this.width, this.height);
  }
  inXBound(ballX) {
   return (ballX >= this.posX) && (ballX <= this.posX + this.width);
  }
  inYBound(ballY) {
    return (ballY >= this.posY) && (ballY <= this.posY + this.height);
   }
}