import { Url } from 'url';
import { SafeResourceUrl } from '@angular/platform-browser/src/security/dom_sanitization_service';

export class Card {
  title: String;
  description: String;
  imgSource?: String;
  videoSource?: SafeResourceUrl;
  playTime?: number;
  playability?: boolean;
}
