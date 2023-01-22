const soundIcon = document.getElementById("sound-icon");
let isSoundMuted = false;

soundIcon.addEventListener("click", function() {
  if (isSoundMuted) {
    // unmute the sound
    isSoundMuted = false;
    soundIcon.src = "https://icon-library.com/images/sound-icon-vector/sound-icon-vector-3.jpg";
  } else {
    // mute the sound
    isSoundMuted = true;
    soundIcon.src = "https://icon-library.com/images/sound-icon-vector/sound-icon-vector-3.jpg";
  }
});
